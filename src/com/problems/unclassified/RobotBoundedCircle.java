package com.problems.unclassified;

import java.util.HashSet;
import java.util.Set;

public class RobotBoundedCircle {

    public static void main(String[] args){
        String instructions = "GL";
        System.out.println(isCycle(instructions));
    }

    private static boolean isCycle(String instructions){
        Position current = new Position(0,0);
        Set<Position> positions = new HashSet<>();
        positions.add(current);
        int direction = 0; // {N, E, S, W}
        for(int i=0;i<instructions.length();i++){
            char instruction = instructions.charAt(i);
            switch(instruction){
                case 'L':
                    if(direction == 0) direction=3;
                    else direction--;
                    break;
                case 'R':
                    if(direction == 3) direction=0;
                    else direction++;
                    break;
                case 'G':
                    current = move(current, direction);
                    break;
                default:
                    throw new UnsupportedOperationException("Unsupported instruction");
            }
        }
        return (current.x == 0 && current.y == 0) || direction!=0;
    }

    private static Position move(Position current, int direction){
        switch(direction){
            case 0:
                return current.forward();
            case 1:
                return current.right();
            case 2:
                return current.backwards();
            case 3:
                return current.left();
            default:
                throw new UnsupportedOperationException("Unsupported direction");
        }
    }

    private static class Position{
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position forward(){
            this.y++;
            return this;
        }

        public Position left(){
            this.x--;
            return this;
        }

        public Position right(){
            this.x++;
            return this;
        }

        public Position backwards(){
            this.y--;
            return this;
        }
    }
}
