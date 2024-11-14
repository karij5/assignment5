
class Main {
    public static void main(String[] args) {
        
        int[] processID = { 1, 2, 3, 4, 5 };
        
        int[] burstTimes = { 2, 1, 8, 4, 5 };
        
        //the loop below is used for getting completion times, which are used in calculating turnaround times
        int completionsSum = 0;
        int[] completionTimes = new int[5];
        
        for (int i = 0 ; i < 5 ; i++){
            completionTimes[i] = completionsSum+burstTimes[i];
            completionsSum = completionsSum+burstTimes[i];
            //System.out.println(completionTimes[i]);
        }
        
        //didn't end up using this, since arrival time is zero for everything the turnaround time is the same as completion time.
        int[] turnaroundTimes = new int[5];
        
        
        int[] waitingTimes = new int[5];
        
        for (int i = 0 ; i < 5 ; i++ ){
            waitingTimes[i] = completionTimes[i] - burstTimes[i];
            //System.out.println(waitingTimes[i]);
        }
        
        System.out.println("---------FCFS---------");
        for (int i = 0 ; i < 5 ; i++) {
            System.out.println("Process #" + processID[i] + ": ");
            System.out.println("Turnaround Time: " + completionTimes[i]);
            System.out.println("Waiting Time: " + waitingTimes[i] + "\n");
            
        
        }
        
        //In retrospect I probably would have done this a different way by pairing the process ID and the burst time but I figure for this example it'd be fine to have a separate pair of arrays for each scheduling algorithm since the orders of processes are different for each.
        int[] sjfProcessID = { 2, 1, 4, 3, 5 };
        
        int[] sjfBurstTimes = { 1, 2, 4, 5, 8 };
        
        int[] sjfCompletionTimes = new int[5];
        
        //follows the same idea where completion times are calculated, then used as turnaround times since arrival time is at time 0 for all processes, as per the instructions.
        int sjfCompletionsSum = 0;
        for(int i = 0 ; i < 5 ; i++){
            sjfCompletionTimes[i] = sjfCompletionsSum + sjfBurstTimes[i];
            sjfCompletionsSum = sjfCompletionsSum + sjfBurstTimes[i];
        }
        
        int[] sjfWaitingTimes = new int[5];
        for (int i = 0 ; i < 5 ; i++ ){
            sjfWaitingTimes[i] = sjfCompletionTimes[i] - sjfBurstTimes[i];
            //System.out.println(waitingTimes[i]);
        }
        
        System.out.println("---------SJF---------");
        for (int i = 0 ; i < 5 ; i++) {
            System.out.println("Process #" + sjfProcessID[i] + ": ");
            System.out.println("Turnaround Time: " + sjfCompletionTimes[i]);
            System.out.println("Waiting Time: " + sjfWaitingTimes[i] + "\n");
        }
    }
}