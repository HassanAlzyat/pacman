package com.example.demo3;

import java.util.Collection;
import javafx.geometry.Bounds;
import javafx.scene.Node;

/**
 *
 * @author hassan
 */
public class CollisionDetection {

    public static boolean isCollieded(Node pacman, Collection<Node> nodes) {
        Bounds CharBounds = pacman.getBoundsInParent();
        for (Node node : nodes) {
            if (node.getBoundsInParent().intersects(CharBounds)) {
                return true;
            }
        }

        return false;

    }
}
