package com.problems.basics.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZigZagTraverse {
    public static void main(String[] args) {

    }

    public enum Direction{
        DOWN, // 0
        DIAG_UP, // 1
        DIAG_DOWN, // 3
        RIGHT // 2
    }

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Integer> results = new ArrayList<>();
        if(array.size() == 1) results = array.get(0);
        else if(array.get(0).size() == 1) for(List<Integer> list : array) results.add(list.get(0));
        else{
            int i = 0, j = 0;
            results.add(array.get(i).get(j));
            Direction direction = Direction.DOWN;
            while(i < array.size() && j < array.get(0).size()){
                direction = getNextDirection(i, j, direction, array);
                if(direction.equals(Direction.DOWN)) i++;
                else if(direction.equals(Direction.DIAG_UP)){
                    i--;
                    j++;
                }else if(direction.equals(Direction.RIGHT)) j++;
                else{
                    i++;
                    j--;
                }
            }
        }
        return results;
    }

    public static Direction getNextDirection(int row, int col, Direction direction, List<List<Integer>> array){
        switch(direction){
            case DOWN:
                if(col == array.get(0).size() - 1) direction = Direction.DIAG_DOWN;
                else direction = Direction.DIAG_UP;
                break;

            case DIAG_UP:
                if(row > 0 && col < array.get(0).size()) break;
                else if(col == array.get(0).size() - 1) direction = Direction.DOWN;
                else direction = Direction.RIGHT;
                break;

            case RIGHT:
                if(row == 0) direction = Direction.DIAG_DOWN;
                else direction = Direction.DIAG_UP;
                break;

            case DIAG_DOWN:
                if(row < array.size() && col > 0) break;
                else if(row == array.size() - 1) direction = Direction.RIGHT;
                else direction = Direction.DOWN;
                break;
        }
        return direction;
    }
}
