package Mission01;

// Thread의 자식 클래스 생성한 뒤 run() 메서드 작성하기.

class Worker extends Thread {
    public void run(){
        //for 문을 사용해 1초마다 0부터 하나씩 증가해서 5초동안 출력
        for(int i = 0; i < 5; i++){
            System.out.println("작업 스레드 : " + i);
            try{
                Thread.sleep(1000); // 1초
            } catch (InterruptedException exit){
            }
        }
    }
}
// 테스트 프로그램 작성하기. 'a'를 하나씩 증가시키면서 문자로 출력하기.
public class Mission0214 {
    public static void main(String[] args) {
        int alphabet = 'a';
        // 작업 스레드 객체 생성 및 시작
        // 작업 스레드가 살아 있을 동안 메인 스레드의 작업을 수행

        Thread t = new Worker();
        t.start();
        for( ; alphabet < 'z' + 1 ; alphabet++ ){
            if(!t.isAlive())
                break;
            System.out.println("메인 스레드 : " + (char) alphabet);
            try {
                Thread.sleep(500); // 0.5초
            }catch (InterruptedException exit){

            }
        }
    }
}