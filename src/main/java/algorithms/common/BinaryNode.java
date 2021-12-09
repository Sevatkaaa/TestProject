package algorithms.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BinaryNode {
    private BinaryNode left;
    private BinaryNode right;
    private Integer value;
}
