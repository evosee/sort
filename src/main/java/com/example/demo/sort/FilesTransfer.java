package com.example.demo.sort;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class FilesTransfer {
    public static void main(String[] args) {
        Path path = Paths.get(FilesTransfer.path);
        new FilesTransfer().move(path);
    }

    private static final String path = "E:\\1212";
    private static final Integer num = 5;
    private AtomicInteger seq = new AtomicInteger(1);

    public void move(Path path) {
        try {
            List<Path> paths = Files.list(path).collect(Collectors.toList());
            List<Path> files = new ArrayList<>(paths.size());
            for (Path e : paths) {
                if (Files.isDirectory(e)) {
                    move(e);
                } else {
                    files.add(e);
                }
            }
            transfer(path, files);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void transfer(Path path, List<Path> files) {
        if (files.size() > num) {
            List<List<Path>> p = getLists(files);
            p.forEach(e->{
                int s = seq.getAndIncrement();
                String path2 = path +"\\"+s;
                try {
                    Files.createDirectory(Paths.get(path2));
                    e.forEach(file->{
                        try {
                            Path fileName = file.getFileName();
                            Files.move(file,Paths.get(path2,fileName.toString()), StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    });
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            });


        }
    }

    @NotNull
    private List<List<Path>> getLists(List<Path> files) {
        int size = files.size();
        int i = size % num;
        int k;
        if (i == 0) {
            k = size / num;
        } else {
            k = (size / num) + 1;
        }
        List<List<Path>> p = new ArrayList<>();
        for (int j = 0; j < k; j++) {
            if (j == k-1) {
                p.add(files.subList(j * num, size));
            } else {
                p.add(files.subList(j * num, (j + 1) * num));
            }

        }
        return p;
    }
}
