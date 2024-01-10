import java.util.*;

class PGS_아이템_줍기 {
    static boolean[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static class Point{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new boolean[104][104];
        int x1, y1, x2, y2;
        for(int i=0; i<rectangle.length; i++){
            x1 = rectangle[i][0] * 2;
            y1 = rectangle[i][1] * 2;
            x2 = rectangle[i][2] * 2;
            y2 = rectangle[i][3] * 2;

            for(int j=x1; j<=x2; j++){
                for(int k=y1; k<=y2; k++){
                    map[j][k] = true;
                }
            }
        }

        for(int i=0; i<rectangle.length; i++){
            x1 = rectangle[i][0] * 2;
            y1 = rectangle[i][1] * 2;
            x2 = rectangle[i][2] * 2;
            y2 = rectangle[i][3] * 2;

            for(int j=x1+1; j<=x2-1; j++){
                for(int k=y1+1; k<=y2-1; k++){
                    map[j][k] = false;
                }
            }
        }

        Point start = new Point(characterX * 2, characterY * 2);
        Point end = new Point(itemX * 2, itemY * 2);

        return bfs(start, end) / 2;
    }

    static int bfs(Point start, Point end){
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[104][104];

        queue.add(start);
        visited[start.x][start.y] = true;

        Point current;
        int size, cnt = 0;
        while(!queue.isEmpty()){
            size = queue.size();

            for(int i=0; i<size; i++){
                current = queue.poll();

                if(current.x == end.x && current.y == end.y) return cnt;

                for(int j=0; j<4; j++){
                    int tx = current.x + dx[j];
                    int ty = current.y + dy[j];

                    if(visited[tx][ty]) continue;
                    if(!map[tx][ty]) continue;

                    queue.add(new Point(tx, ty));
                    visited[tx][ty] = true;
                }
            }

            cnt++;
        }

        return 0;
    }
}