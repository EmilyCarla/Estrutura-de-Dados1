import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TorreHanoi{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
       
        System.out.println("Informe a quantidade de discos: ");
        int numDiscos = input.nextInt();

        Long inicioTempo = System.currentTimeMillis();
        Long qntdMovimentos = (long) hanoi(numDiscos, "origem", "destino", "auxiliar");
        Long fimTempo = System.currentTimeMillis();

        System.out.println("\nQuantidade de Discos: " + numDiscos);
        System.out.println("Quantidade de movimentos: " + qntdMovimentos);
        System.out.println("Tempo percorrido: " + formatarTempo(fimTempo - inicioTempo));

        input.close();

    }

    public static Long hanoi(int numDiscos, String origem, String destino, String auxiliar){
        if(numDiscos<=1){
            return (long) 1;
        }else{
            Long movimento1 = hanoi(numDiscos-1, origem, auxiliar, destino);
            Long movimento2 = hanoi(numDiscos-1, auxiliar, destino, origem);
            return movimento1 + movimento2 + 1;
        }
    }

    public static String formatarTempo(long tempo){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");
    return LocalTime.ofNanoOfDay(tempo * 1_000_000).format(formatador);
    }
}