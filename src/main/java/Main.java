import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //инициализация списка игрушек разными методами
        ToyList toys1 = new ToyList();
        toys1.addToy(new Toy(25,"Мягкая игрушка",3));
        toys1.addToyList(List.of(
                new Toy(5,"Вертолет",1),
                new Toy(10,"Спиннер",2),
                new Toy(10,"Фигурки",2)
        ));
        System.out.println(toys1);

        //инициализация очереди участников
        ParticipantQueue pq = new ParticipantQueue(List.of(
                new Participant("Никита"),
                new Participant("Оля"),
                new Participant("Саша"),
                new Participant("Максим"),
                new Participant("Олег"),
                new Participant("Ваня"),
                new Participant("Дима"),
                new Participant("Руслан"),
                new Participant("Федя"),
                new Participant("Аня")
        ));

      //сам розыгрыш
         //Вывод бросков для наглядности расчета можно сделать, раскомментировав 42-ю строчку в Raffle
        Raffle raf = new Raffle(pq,toys1);
        System.out.println(raf.currentToys.toString());
        raf.runRaffle();

        System.out.println("\nРозыгрыш с вероятностью проиграть\n");
        ParticipantQueue pqloss = new ParticipantQueue();
        for (int i = 1; i <= 10 ; i++){
            pqloss.addParticipant(new Participant());
        }
        Raffle raf2 = new Raffle(pqloss,toys1);
        raf2.setLossWeight(30);
        System.out.println(raf2.currentToys.toString());
        raf2.runRaffle();

        //Можно записать финальное состояние призов для склада
        toys1.saveToFile();
    }

}
