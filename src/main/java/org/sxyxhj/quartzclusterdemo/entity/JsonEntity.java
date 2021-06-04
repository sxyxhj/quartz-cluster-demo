package org.sxyxhj.quartzclusterdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: quartz-cluster-demo
 * @description:
 * @author: elroyh
 * @create: 2021-06-04 14:35
 **/

@Data
@AllArgsConstructor
public class JsonEntity implements Serializable {

    private static final long serialVersionUID = -3309954137658927703L;

    public int status;
    public String message;


}
