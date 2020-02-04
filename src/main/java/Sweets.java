
import Cakes.Butterscotch;
import Cakes.Fruit;
import Cakes.Vanilla;
import Candies.Candies;
import Candies.Caramels;
import Candies.Gummies;
import Candies.Lollipops;

import java.util.*;

public class Sweets {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        ArrayList<Chocolate> chocolates= new ArrayList<Chocolate>();
        ArrayList<Double> weights= new ArrayList<Double>();
        HashMap<String,Double> map = new HashMap<String, Double>();
        HashMap<String,Double> pricemap = new HashMap<String, Double>();
        do {

            System.out.println("What kind of sweets would you like to have?");
            System.out.println("Options: - \n 1. Chocolates \n 2. Cakes \n 3. Candies");
            System.out.println("Press 1 for chocolates , 2 for cakes and 3 for candies and 0 to exit and see the total weight and chocolates sorted by price");
            n=sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("CHOCOLATES");

                        System.out.println("Here are some of our options- \n 1) Amul Milk Chocolate \n 2) Hersheys Milk Chocolate \n 3) Cadbury dairy milk chocolate \n Press 'a' for amul 'c' for cadbury and 'h' for hersheys");
                        char c = sc.next().charAt(0);
                        Chocolate ch;
                        if(c=='a')
                        {
                            ch=new Amulm();
                            if(ch instanceof Amulm) {
                                Amulm am = (Amulm) ch;
                                chocolates.add(am);
                                weights.add(am.getWeight());
                                map.put("Amul Chocolate",am.getWeight());
                                pricemap.put("Amul Chocolate",am.getPrice());
                            }
                        }
                        else if(c=='c')
                        {
                            ch=new Cadburym();
                            if(ch instanceof Cadburym) {
                                Cadburym cm = (Cadburym) ch;
                                chocolates.add(cm);
                                weights.add(cm.getWeight());
                                map.put("Cadbury Chocolate",cm.getWeight());
                                pricemap.put("Cadbury Chocolate",cm.getPrice());
                            }
                        }
                        else
                        {
                            ch=new Hersheysm();
                            if(ch instanceof Hersheysm) {
                                Hersheysm hm = (Hersheysm) ch;
                                chocolates.add(hm);
                                weights.add(hm.getWeight());
                                map.put("Hershey Chocolate",hm.getWeight());
                                pricemap.put("Hershey Chocolate",hm.getPrice());
                            }

                        }
                    break;
                case 2:
                    System.out.println("CAKES");
                    System.out.println("Enter the type of cakes you would like to have? \n OPTIONS -: \n 1) Butterscotch \n 2) Fruit \n 3)Vanilla. Press b for butterscotch,f for fruit and v for vanilla");
                    char ch2 = sc.next().charAt(0);
                    if(ch2=='b') {
                        System.out.println("BUTTERSCOTCH cake added to gift");
                        Butterscotch but = new Butterscotch();
                        weights.add(but.getWeight());
                        map.put("ButterScotch Cake",but.getWeight());
                        pricemap.put("ButterScotch Cake",but.getPrice());
                    }
                    else if(ch2=='f') {
                        System.out.println("FRUIT Cake added to gift");
                        Fruit fruit = new Fruit();
                        weights.add(fruit.getWeight());
                        map.put("Fruit Cake",fruit.getWeight());
                        pricemap.put("Fruit Cake",fruit.getPrice());
                    }
                    else if(ch2=='v') {
                        System.out.println("VANILLA Cake added to gift");
                        Vanilla van = new Vanilla();
                        weights.add(van.getWeight());
                        map.put("Vanilla Cake",van.getWeight());
                        pricemap.put("Fruit Cake",van.getPrice());
                    }
                    else
                        System.out.println("invalid choice");
                    break;

                case 3:
                    System.out.println("CANDIES");
                    System.out.println("\n Enter the type of candies you would like to have? \n OPTIONS -: \n 1) Caramels \n 2) Gummies \n 3)Lollipops .Press c for caramels , g for gummies and l for lollipops");
                    char ch3 = sc.next().charAt(0);
                    Candies can;
                    if(ch3=='c') {
                        System.out.println("Caramels are added to your gift");
                        can = new Caramels();
                        weights.add(can.getWeight());
                        map.put("Caramel candy",can.getWeight());
                        pricemap.put("Caramel candy",can.getPrice());
                    }
                    else if(ch3=='g') {
                        System.out.println("gummies are added to your gift");
                        can= new Gummies();
                        weights.add(can.getWeight());
                        map.put("Gummies candy",can.getWeight());
                        pricemap.put("Gummies candy",can.getPrice());
                    }
                    else if(ch3=='l') {
                        System.out.println("lollipops are added to your gift");
                        can= new Lollipops();
                        weights.add(can.getWeight());
                        map.put("Lollipop candy",can.getWeight());
                        pricemap.put("Lollipop candy",can.getPrice());
                    }
                    else
                        System.out.println("invalid choice");
                    break;
                case 0:
                    //Sorting By price
                    Collections.sort(chocolates , new Sortbyprice());
                    System.out.println("\nAll the Chocolates Sorted by price -> ");
                    for (int i=0; i<chocolates.size(); i++)
                        System.out.println(chocolates.get(i).getPrice());

                    Iterator itr = map.entrySet().iterator();
                    while (itr.hasNext()) {
                        Map.Entry<String, Double> val = (Map.Entry<String, Double>) itr.next();
                        String mapKey=  val.getKey();
                        System.out.println("Sweet Name:- " + mapKey + ", Weights:- " + map.get(mapKey));
                    }

                    //Sorting by Range
                    System.out.println("Enter the initial price range");
                    int init = sc.nextInt();
                    System.out.println("Enter the highest price range");
                    int highest = sc.nextInt();

                    Iterator itr2 = pricemap.entrySet().iterator();
                    while (itr2.hasNext()) {
                        Map.Entry<String, Double> val = (Map.Entry<String, Double>) itr2.next();
                        Double price = val.getValue();
                        if(price>=init && price <=highest)
                            System.out.println("Sweet Name:- " + val.getKey() );
                        else
                            continue;
                    }

                    //Total Weight
                    System.out.println("And the total weight of all the sweets");
                    double sum = 0;
                    for (int i=0; i<weights.size(); i++) {
                        sum+=weights.get(i);
                    }
                    System.out.println(sum);
                    System.out.println("Thankyou for buying sweets from us!!");

                    break;
                default:
                    System.out.println("Invalid Option :(");
            }
        }while(n!=0);
    }
    }

