class Main {
    public static void main(String[] args) {
        Board board = new Board();
        CPUPlayer cpu = new CPUPlayer(Mark.X);
        cpu.alphaBeta(board, 0, cpu, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        System.out.println(cpu.getNumOfExploredNodes());
    }
}