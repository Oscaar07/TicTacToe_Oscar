class Main {
    public static void main(String[] args) {
        Board board = new Board();
        CPUPlayer cpu = new CPUPlayer(Mark.X);
        System.out.println(cpu.getNextMoveAB(board));
    }
}