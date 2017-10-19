import java.util.*;
import java.io.*;

class ContinuousMedian{
  Queue<Integer> maxQ;
  Queue<Integer> minQ;
  ContinuousMedian(){
    maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());
    minQ = new PriorityQueue<Integer>();
  }
  void balance(){
    maxQ.add(minQ.poll());
  }
  void add(int input){
    if(maxQ.size()==0){
      maxQ.add(input);
      return;
    }
    if(input<=maxQ.peek()){
      maxQ.add(input);
    } else{
      minQ.add(input);
    }
    if(Math.abs(minQ.size()-maxQ.size())>1){
      if(minQ.size()>maxQ.size()){
        maxQ.add(minQ.poll());
      } else {
        minQ.add(maxQ.poll());
      }
    }
  }
  double findMedian(){
    if(Math.abs(minQ.size()-maxQ.size())==0){
      return (double)(minQ.peek()+maxQ.peek())/2;
    } else {
      if(maxQ.size()>minQ.size()){
        return maxQ.peek();
      } else {
        return minQ.peek();
      }
    }
  }
}

public class Main{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    ContinuousMedian median = new ContinuousMedian();
    int n = in.nextInt();
    while(n-->0){
      median.add(in.nextInt());
      System.out.println(median.findMedian());

    }
  }
}
