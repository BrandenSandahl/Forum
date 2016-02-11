import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by branden on 2/11/16 at 11:16.
 */
public class Forum {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Post> posts = new ArrayList<>();
        Scanner consoleScanner = new Scanner(System.in);


        //reading posts into memory
        File f = new File("posts.txt");
        Scanner fileScanner = new Scanner(f);

        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Post post = new Post(Integer.valueOf(columns[0]), columns[1], columns[2]);
            posts.add(post);
        }

        int replyId = -1;
        while (true) {
            //loops over all posts, print ones with the right rep id
            int id = 0;
            for (Post p : posts) {
                if (p.replyId == replyId) {
                    System.out.printf("(%d). %s by %s\n", id, p.text, p.author);
                }
                id++;
            }
            //ask user to change reply id
            System.out.println("");
            System.out.println("Type the id you want to view: ");
            replyId = Integer.parseInt(consoleScanner.nextLine());
        }

    }


}