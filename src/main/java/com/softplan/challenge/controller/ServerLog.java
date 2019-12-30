package com.softplan.challenge.controller;

import com.softplan.challenge.util.ServerLogUtil;
import lombok.Getter;
import lombok.Setter;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
@Getter
@Setter
public class ServerLog implements Serializable {

    String file = "target/log/server.log";
    String data;
    String id;
    private int offset = 0;
    private int pageSize = 30;

    public String actionNextPage() {
        StringBuilder page = new StringBuilder();

        for (int i = 0; i < pageSize; i++) {
            String line = ServerLogUtil.readLine(offset, file);
            if (line == null) {
                break;
            }
            System.out.println(offset);
            offset += line.length() + 2;
            page.append(line).append(System.getProperty("line.separator"));
        }
        this.data = page.toString();
        return "SUCCESS";
    }
}