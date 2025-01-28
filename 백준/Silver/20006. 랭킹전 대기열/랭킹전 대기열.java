import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] pm = br.readLine().split(" ");
        int p = Integer.parseInt(pm[0]);
        int m = Integer.parseInt(pm[1]);

        MatchingQueue mq = new MatchingQueue();

        while(p-- > 0){
            String[] split = br.readLine().split(" ");
            int level = Integer.parseInt(split[0]);
            String name = split[1];

            Player player = new Player(level, name);

            if(mq.rooms.isEmpty()){
                Room room = new Room(player, m);
                mq.rooms.add(room);
            }else{
                boolean flag = false;
                for(int i = 0; i < mq.rooms.size(); i++){
                    if(mq.rooms.get(i).players.size() < m && mq.rooms.get(i).standard.level - 10 <= player.level && mq.rooms.get(i).standard.level + 10 >= player.level){
                        mq.rooms.get(i).players.add(player);
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    Room room = new Room(player, m);
                    mq.rooms.add(room);
                }
            }
        }

        for(Room room : mq.rooms){
            room.printRoomState(bw);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Player{
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }

    static class Room{
        Player standard;
        List<Player> players;
        int size;

        public Room(Player standard, int size) {
            this.standard = standard;
            this.players = new ArrayList<>();
            this.players.add(standard);
            this.size = size;
        }

        public void printRoomState(BufferedWriter bw) throws IOException {
            if(players.size() == size){
                bw.append("Started!\n");
            }else{
                bw.append("Waiting!\n");
            }

            players.sort(new PlayerComparator());
            for(Player player : players){
                bw.append(Integer.toString(player.level)).append(" ").append(player.name).append("\n");
            }
        }
    }

    static class MatchingQueue{
        List<Room> rooms;

        public MatchingQueue() {
            this.rooms = new ArrayList<>();
        }

        public void addRoom(Room room){
            this.rooms.add(room);
        }
    }

    static class PlayerComparator implements Comparator<Player>{

        @Override
        public int compare(Player o1, Player o2) {
            return o1.name.compareTo(o2.name);
        }
    }
}