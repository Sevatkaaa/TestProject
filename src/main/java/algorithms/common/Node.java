package algorithms.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Node {
    private List<Node> children = new ArrayList<>();
    private Integer value;
}
