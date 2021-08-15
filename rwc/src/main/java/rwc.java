import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class rwc {

    public static void main(String[] args)   {
        if (args.length < 2) {
            System.out.println("usage filename lost\n");
            return;
        }

        System.out.println("filename " + args[1]);
        File file = new File(args[1]);
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while ((str = in.readLine()) != null) {
                lines.add(str);
            }
        } catch (Exception e) {

        }
        String content = String.join("", lines);
        int num = content.split(" ").length;
        //int cnum = content.
        System.out.println("linenum " + lines.size() + "\nword num " + num);
    }
}
