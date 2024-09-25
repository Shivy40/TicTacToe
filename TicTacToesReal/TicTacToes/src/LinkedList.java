
public class LinkedList {

    private Node head;  // Head of the linked list

    // Constructor to initialize an empty linked list
    public LinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the end
    public void insertAtEnd(String data) {
    Node newNode = new Node(data);  
    if (head == null) {
        head = newNode;  
    } else {
        Node current = head;
     
        while (current.next != null) {
            current = current.next;
        }
        
        current.next = newNode;
    }
}
    // Method to update a specific position in the list
   public void updatePosition(int position, String data) {
    Node current = head;
    int count = 1;
 
    while (current != null && count < position) {
        current = current.next;
        count++;
    }
    
    if (current != null) {
        current.data = data;
    }
}

    // Method to get the value at a specific position
    public String getPositionValue(int position) {
    Node current = head;
    int count = 1;
   
    while (current != null && count < position) {
        current = current.next;
        count++;
    }
    
    
    return current != null ? current.data : "";
}
    
    
    
    // Method to display the Tic Tac Toe board
    public void displayBoard() {
   
        Node current = head;
    int count = 1;
    while (current != null) {
        
        System.out.print(current.data.equals("") ? "-" : current.data);
       
        if (count % 3 == 0) {
            System.out.println();
        } else {
            System.out.print(" | ");
        }
        current = current.next;
        count++;
    }
}

    // Method to check for a win
    public boolean checkWinCondition() {
    String[] board = new String[9];
    Node current = head;
    int index = 0;

   
    while (current != null && index < 9) {
        board[index] = current.data;
        current = current.next;
        index++;
    }

    
    if ((board[0].equals(board[1]) && board[1].equals(board[2]) && !board[0].equals("")) ||  // First row
        (board[3].equals(board[4]) && board[4].equals(board[5]) && !board[3].equals("")) ||  // Second row
        (board[6].equals(board[7]) && board[7].equals(board[8]) && !board[6].equals("")) ||  // Third row
        (board[0].equals(board[3]) && board[3].equals(board[6]) && !board[0].equals("")) ||  // First column
        (board[1].equals(board[4]) && board[4].equals(board[7]) && !board[1].equals("")) ||  // Second column
        (board[2].equals(board[5]) && board[5].equals(board[8]) && !board[2].equals("")) ||  // Third column
        (board[0].equals(board[4]) && board[4].equals(board[8]) && !board[0].equals("")) ||  // Diagonal 1
        (board[2].equals(board[4]) && board[4].equals(board[6]) && !board[2].equals(""))) {  // Diagonal 2
        return true;  
    }

    return false; 
}
    // Method to check if the board is full (for draw condition)
   public boolean isBoardFull() {
    Node current = head;
    while (current != null) {
        if (current.data.equals("")) {
            return false;  
        }
        current = current.next;
    }
    return true;  
}


    // Method to reset the board
public void resetBoard() {
    Node current = head;
    while (current != null) {
        current.data = "";  
        current = current.next;
    }
}
}
