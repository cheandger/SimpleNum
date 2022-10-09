import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import static java.lang.Math.sqrt;

// Трогаем стримы и потоки ввода/вывода за всякое
/*Задача: прочитать файл с числами, вывести в консоль только простые числа (можно еще записать в файлик)*/


public class SimpleNumRun {


    public static void main(String[] args) throws IOException {


        BufferedReader numFile = new BufferedReader(new FileReader("D:\\Nums.txt")); // тащемта, берем файл, прописываем к нему путь
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\simpleNum.txt", false));// создадим файл для вывода, причем запретим аппенд, пусть каждый раз новый пишет


        try {

          List<Integer> arrayOfNum = Stream.of(numFile.readLine().split("\\s"))// читаем строку, разбиваем по разделителю(я бил по пробелу, но можно какойнить вкусный регэксп
                                                                                     //  мало ли кто и как делить их будет ,но в задаче про это не сказано
                    .map(Integer::valueOf)// вооот, не использовать парсИнт(!), а то outOfBound вылетит
                    .filter(var -> {
                                for (Integer i = 2; i <= sqrt(var); i++)// Здравствуйте, JS и Python, я не скучал по вам.
                                    if (var % i == 0)
                                        return false;/*Собсно Stream API во всей красе, в одну строчку кучу действий*/
                                return true;
                            }
                    ).toList();//терминальная операция, после этого стрим все, как дядя Изя. Тоесть закрывать ничего не надо, блок finally не нужен.

          for (Integer i:arrayOfNum){
            bw.write(i.toString());
            bw.append("\n");
            System.out.println(i);}



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






























            /*int [] numbers =Arrays.stream(numFile.readLine().split("\\s"))
                    .mapToInt(Integer::parseInt)
                    .toArray(); */ //как вариант, если допустимо использование int
            /*static Optional <Integer> toInteger(String opt){
            try{
            return Optional.of(Integer.valueOf(opt))}
            catch(NumberFormatException ex){
            return Optional.empty()}}


            for (String str : numStr) {
                Integer num = Integer.parseInt(str);

                boolean first = (num != 1);
                boolean second = true;

                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        second = false;
                        break;
                    }
                    second = true;
                }

            if ((first && second)) {
                bw.write(num.toString());
                bw.append("\n");
                System.out.println(num);

            }
        }

                //Integer myInt =Integer.getInteger(Arrays.toString();

               // System.out.println(numStr);
               // System.out.println(numStr.getClass());
                //Integer [] numArray = myInt.split("\\s");


        } finally {
            numFile.close();
            bw.close();
        }
    }
}
*/

