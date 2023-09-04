import java.io.*;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Login or register?");

        String choice = scanner1.nextLine();
        if (choice.equals("register")){
            register();
        }else{
            login();
        }

    }


    public static void login() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username");

        String username = scanner.nextLine();


        File file = new File("C:\\Users\\KalleNY\\IdeaProjects\\Calculator\\src\\users.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        String s;
        String input = username;   // Input word to be searched
        int count=0;   //Intialize the word to zero
        while((s=br.readLine())!=null)   //Reading Content from the file
        {
            String[] words = s.split(" ");  //Split the word using space
            for (String word : words)
            {
                if (word.equals(input))   //Search for the given word
                {
                    count++;    //If Present increase the count by one
                }
            }
        }
        if(count!=0)  //Check for count not equal to zero
        {
            System.out.println("Correct username");
        }
        else
        {
            System.out.println("The given username is not yet registered, do you want to try again(1) or register(2)?");
            String choice = scanner.nextLine();
            if (choice.equals("1")){
                login();
            }else{
                register();
            }
        }

        fr.close();
    }

    public static void register() throws FileNotFoundException {
        Scanner scanner2 = new Scanner(System.in);

        System.out.println("Enter Name");
        String name = scanner2.nextLine();

        System.out.println("Enter username");
        String usernameinput = scanner2.nextLine();

        PrintWriter writer = new PrintWriter("C:\\Users\\KalleNY\\IdeaProjects\\Calculator\\src\\users.txt");
        writer.println(usernameinput);
        writer.close();
    }
    }
