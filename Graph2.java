// Java program to print all paths of source to
// destination in given graph
import java.io.*;
import java.util.*;

class Graph {
    // Utility function to check if current
// vertex is already present in path
    private static boolean isNotVisited(int x,
                                        List<Integer> path) {
        int size = path.size();
        for (int i = 0; i < size; i++)
            if (path.get(i) == x)
                return false;

        return true;
    }

    // Utility function for finding paths in graph
// from source to destination
    private static void findpaths(List<List<Integer>> g,
                                  int src, int dst, int v) {

        // Create a queue which stores
        // the paths
        Queue<List<Integer>> queue = new LinkedList<>();
        int count = 0;

        // Path vector to store the current path
        List<Integer> path = new ArrayList<>();
        path.add(src);
        queue.offer(path);

        while (!queue.isEmpty()) {
            path = queue.poll();
            int last = path.get(path.size() - 1);

            // If last vertex is the desired destination
            // then print the path
            if (last == dst) {
                count++;
            }

            // Traverse to all the nodes connected to
            // current vertex and push new path to queue
            List<Integer> lastNode = g.get(last);
            for (int i = 0; i < lastNode.size(); i++) {
                if (isNotVisited(lastNode.get(i), path)) {
                    List<Integer> newpath = new ArrayList<>(path);
                    newpath.add(lastNode.get(i));
                    queue.offer(newpath);
                }
            }
        }
        System.out.println(count);
    }

    // Driver code
    public static void main(String[] args) throws IOException, Exception {
        List<List<Integer>> g = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        for (int i = 0; i < v; i++) {
            g.add(new ArrayList<>());
        }

        int a=-1;
        for(int i=0;i<=v;i++) {

            String line = s.nextLine();
            String[] numberStrs = line.split(" ");
            ArrayList<Integer> numbers = new ArrayList<>();
            for(int j = 0;j < numberStrs.length;j++)
            {
                try{
                    if(!numberStrs[j].equals(""))
                    numbers.add(Integer.parseInt(numberStrs[j]));
                }
                catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            if(numbers.isEmpty()) a++;
            else {
                for (int q : numbers) {

                    if
                    (q >= 0) g.get(a).add(q);
                    else
                        a++;
                }

                a++;
            }
            //System.out.println(g.get(i));
        }


            int src = 0, dst = v - 1;
            // Function for finding the paths
            findpaths(g, src, dst, v);
      //  System.out.println(g);


    }
}

