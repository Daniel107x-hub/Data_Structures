package mentorias.week3;

import java.util.*;

public class OpenTheLock {
    public static void main(String[] args) {
        String[] deadEnds = {
                "8887","8889","8878","8898","8788","8988","7888","9888"
        };
        String target = "8888";
        System.out.println(openLock(deadEnds, target));
    }

    public static int openLock(String[] deadends, String target) {
        String password = "0000";
        Set<String> visited = new HashSet<>();
        Collections.addAll(visited, deadends);
        Queue<String> toVisit = new ArrayDeque<>();
        toVisit.offer(password);
        int depth = 0;
        while(!toVisit.isEmpty()){
            int levelSize = toVisit.size();
            for(int i = 0 ; i < levelSize ; i++){
                String parent = toVisit.poll();
                if(visited.contains(parent)) continue;
                if(parent.equals(target)) return depth;
                visited.add(parent);
                for(int j = 0 ; j < 8 ; j ++){
                    String newPassword = modifyDigit(parent, j / 2, j % 2 == 0);
                    if(visited.contains(newPassword)) continue;
                    toVisit.offer(newPassword);
                }
            }
            depth++;
        }
        return -1;
    }

    public static String modifyDigit(String password, int position, boolean increment){
        StringBuilder sb = new StringBuilder(password);
        char currentValue = password.charAt(position);
        if(increment){
            if(currentValue == '9') currentValue = '0';
            else currentValue++;
        }else{
            if(currentValue == '0') currentValue = '9';
            else currentValue--;
        }
        sb.setCharAt(position, currentValue);
        return sb.toString();
    }
}
