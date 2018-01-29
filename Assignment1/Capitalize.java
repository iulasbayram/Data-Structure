//ID: Ulas Bayram NO: 220201040
public class Capitalize {
       public static void main (String[] args) {
                   char a , b , c , d, sample , firstletter , cap_firstletter;
                   firstletter = StdIn.readChar();
                   cap_firstletter = Character.toUpperCase(firstletter);
                   StdOut.print(cap_firstletter);
                   while (!StdIn.isEmpty()) {
                       sample = StdIn.readChar();

                       if(sample=='.' || sample=='?' || sample=='!'){
                           StdOut.print(sample);
                           b= StdIn.readChar();
                           d = StdIn.readChar();
                           c=Character.toUpperCase(d);
                           StdOut.print(b);
                           StdOut.print(c);

                       } else  {
                           StdOut.print(sample);

                       }
                   }


       }
}