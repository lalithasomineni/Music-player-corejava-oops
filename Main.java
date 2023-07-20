

import java.util.*;

public class Main {
  private static ArrayList<Album> albums = new ArrayList<>();

public static void main(String[] args) {
  Album album = new Album("barbie","ryan");

  album.addSong("TNT",4.5);
  album.addSong("Highway to hell",3.5);
  album.addSong("all too well",4.0);
  albums.add(album);

  album = new Album("oppenheimer","cilian morphy");
  album.addSong("lavender haze",4.5);
  album.addSong("RDJ",3.9);
  albums.add(album);

  LinkedList <Song> playList1 = new LinkedList<>();
  albums.get(0).addToPlayList("all too well",playList1);
  albums.get(0).addToPlayList("TNT",playList1);
  albums.get(1).addToPlayList("lavender haze",playList1);
  albums.add(album);
  play(playList1);
}


   private static void play (LinkedList <Song> playList) {
     Scanner sc = new Scanner(System.in);
     boolean quit = false;
     boolean forward = true;
     ListIterator <Song> listIterator = playList.listIterator();

     if(playList.size() <= 0){
       System.out.println("this playlist has no songs");
     }
     else{
       System.out.println("now playing....." + listIterator.next().toString());
       printMenu();
         }
         while(!quit){
           int action = sc.nextInt();
           sc.nextLine();
           switch(action) {
             case 0:
               System.out.println("playlist completed");
               quit = true;
               break;

             case 1:
               if(listIterator.hasNext()){
                 System.out.println("now playing " + listIterator.next().toString());
                 forward = true;

             }
             else{
               System.out.println("no song available");
               forward = false;
             }
             break;
           case 2:
             if(forward = true){
                if(listIterator.hasPrevious()){
                  System.out.println("now playing... " + listIterator.previous().toString());
                  forward = false;
                }
                else{
                  forward = false;
                  System.out.println("no previous songs available");
                }
              }
                break;
            case 3:
              if(forward){
                if(listIterator.hasPrevious()){
                  System.out.println(listIterator.previous().toString());
                }
                }
                else{
                  if(listIterator.hasNext()){
                    System.out.println(listIterator.next().toString());
                    forward = true;
                  }
                }
                  break;
              case 4:
                  printList(playList);
                  break;
              case 5:
                  printMenu();
                  break;
              case 6:
                  if(playList.size() > 0){
                    listIterator.remove();
                    if(listIterator.hasNext()){
                      System.out.println("now playing...." + listIterator.next().toString());
                    }
                    else{
                        if(listIterator.hasPrevious()){
                          System.out.println("now playing..." + listIterator.previous().toString());
                        }
                    }

                    }
                    break;
                  }
              }


             }






          private static void printMenu() {
                   System.out.println("Available options\n press");
                      System.out.println("0 - to quit\n"+
                              "1 - to play next song\n"+
                              "2 - to play previous song\n"+
                              "3 - to replay the current song\n"+
                              "4 - list of all songs \n"+
                              "5 - print all available options\n"+
                              "6 - delete current song");
            }


                      private static void printList(LinkedList<Song>playList){
                        Iterator<Song>iterator = playList.iterator();
                        System.out.println(".............................");

                        while(iterator.hasNext()){
                          System.out.println(iterator.next());
                        }
                        System.out.println("..............................");
                      }

}
