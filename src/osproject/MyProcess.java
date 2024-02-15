package osproject;

public class MyProcess {
    private String processId;
    private String processName;
    private String processState; // Added processState attribute
    private String priority;
    private String arrivalTime;
    private String burstTime;
    private int processPriority;
    private int completionTime; // Added completionTime attribute
    private int turnaroundTime; // Added turnaroundTime attribute
    private int waitingTime; // Added waitingTime attribute

    public MyProcess(String processId, String processName, String processState, String priority, String arrivalTime, String burstTime) {
        this.processId = processId;
        this.processName = processName;
        this.processState = processState;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.processPriority = convertPriorityToInt(priority);
    }

    public int getProcessPriority() {
        return processPriority;
    }

    public String getProcessPriorityAsString() {
        switch (processPriority) {
            case 1:
                return "Low";
            case 2:
                return "Medium";
            case 3:
                return "High";
            default:
                return "Unknown"; // Add appropriate handling for other values
        }
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    // Getters and setters (or use public fields) for each attribute

    public String getProcessId() {
        return processId;
    }

    public String getProcessName() {
        return processName;
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState;
    }

    public String getPriority() {
        return priority;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getBurstTime() {
        return burstTime;
    }

    private int convertPriorityToInt(String priority) {
        switch (priority.toLowerCase()) {
            case "low":
                return 1;
            case "medium":
                return 2;
            case "high":
                return 3;
            default:
                return 0; // Default value for unknown priority
        }
    }

    public int getArrivalTimeAsInt() {
        try {
            return Integer.parseInt(arrivalTime);
        } catch (NumberFormatException e) {
            return 0; // Handle the case where arrivalTime is not a valid integer
        }
    }

    @Override
    public String toString() {
        return "MyProcess{" +
                "processId='" + processId + '\'' +
                ", processName='" + processName + '\'' +
                ", processState='" + processState + '\'' +
                ", priority='" + priority + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", burstTime='" + burstTime + '\'' +
                ", completionTime=" + completionTime +
                ", turnaroundTime=" + turnaroundTime +
                ", waitingTime=" + waitingTime +
                '}';
    }
}




