public class NaturalMerge {
    private static Comparable[] aux;
    
    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];

        for (int sz = 1; sz < N; sz = sz+sz)
            for (int lo = 0; lo < N-sz; lo += sz+sz)
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1,N-1));
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;

        for (int k = lo; k <= hi; ++k)
            aux[k] = a[k];

        for (int k = lo; k <= hi; ++k) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }
    
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i += 1) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i += 1)
            if (less(a[i], a[i-1]))
                return false;
        return true;
    }

    public static void main(String[] args){
        Comparable[] a= StdIn.readAllStrings();
        
        int N= a.length;
        int c=0;
        int count=0;
        int counter=0;
        int processCounter=0;
        Comparable[] subA= new Comparable[0];
        Comparable[] subB= new Comparable[0];
        Comparable[] processA= new Comparable[0];
        int subAlength=0;
        int subBlength=0;
        int i;
        StdOut.println();
        StdOut.println("the length of a is " + N);

        for(i=1; i<N; i++){
            StdOut.println();
            StdOut.println("the number of loop " + a[i-1] + " /// index number " + (i-1));
            
            if (less(a[i],a[i-1]) && counter==0){
                
                StdOut.println();
                StdOut.println();
                StdOut.println();
                subA= new Comparable[i-count];
                subAlength=subA.length;
                
                while(c<i){ //subA oluşturmak için
                    for (int x=0;x<i-count ;x++ ) {
                        subA[x]=a[c];
                        c++;
                    }
                }

                for (int b=0;b<subA.length ;b++ ) { //subA yı yazdırmak için
                    StdOut.println("SubA element is that recpectively " + subA[b]);
                
                }


                
                count=i;
                counter=1;
                StdOut.println();
                StdOut.println("subA length is that " +subA.length);

            
            }
            else if(less(a[i],a[i-1]) && counter==1){
                subB = new Comparable[i-count];
                subBlength=subB.length;
                while(c<i){
                    for(int inx=0; inx<i-count;inx++){
                        subB[inx]=a[c];
                        c++;
                    }
                }
                for (int ynx=0;ynx<subB.length ;ynx++ ) {
                    StdOut.println("SubB element is that respectively " + subB[ynx]);
                }
                

                count=i;
                StdOut.println();
                StdOut.println("subB length is that " +subB.length);
                counter=0;
                processCounter=1;
            }


            if (processCounter==1) {

                processA= new Comparable[count];
                int xx;
                for (xx=0;xx<subAlength ;xx++ ) {
                    processA[xx]=subA[xx];
                    StdOut.println("Process A has elements such that " + processA[xx]);
 
                }


                while(xx<count){
                    for (int yy=0;yy<subBlength ;yy++ ) {
                        processA[xx]=subB[yy];
                        StdOut.println("Process A has elements such that " + processA[xx]);
                        xx++;
                    }
                }
                sort(processA);
                assert isSorted(processA);
                

                for (int xy=0;xy< processA.length ;xy++ ) {
                    a[xy]=processA[xy];
                }

                i=1;
                processCounter=0;
                count=0;
                c=0;


            }



        }
        if(count!=i){
            int d;
            StdOut.println();
            subB= new Comparable[N-count];
            processA= new Comparable[N];
            
            for(int j=0; j<N-count; j++){//sona kalan rakamları subA ya atmak için
                subB[j]=a[j+count];
                StdOut.println();
            }
            

            for (d=0;d < subAlength ;d++ ) {
                processA[d]=subA[d];
            }

            while(d<N){
                for (int aa=0;aa<subB.length ;aa++ ) {
                    processA[d]=subB[aa];
                d++;
                }
            }

            sort(processA);
            assert isSorted(processA);

            for (int cc=0;cc< a.length ;cc++ ) {
                a[cc]=processA[cc];
            }
            
            StdOut.println("AFTER LAST IMPLEMENTATION ");
            StdOut.println();
            show(a);
        }
        
    }
                

}
