import java.lang.reflect.Array;
import java.util.ArrayList;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class CPUPlayer
{

    // Contient le nombre de noeuds visités (le nombre
    // d'appel à la fonction MinMax ou Alpha Beta)
    // Normalement, la variable devrait être incrémentée
    // au début de votre MinMax ou Alpha Beta.
    private int numExploredNodes;

    private Mark cpu;
    private int MaxScore;
    // Le constructeur reçoit en paramètre le
    // joueur MAX (X ou O)
    public CPUPlayer(Mark cpu){
        this.cpu = cpu;
    }

    public Mark getMark(){
        return cpu;
    }

    // Ne pas changer cette méthode
    public int  getNumOfExploredNodes(){
        return numExploredNodes;
    }

    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveAB(Board board){
        ArrayList<Move> moves = new ArrayList<Move>();
        this.MaxScore = Integer.MIN_VALUE;

        for (Move move : board.getMovesPossibles()) {
            Board newBoard = board.clone();
            newBoard.play(move, cpu);
            int score = alphaBeta(newBoard, 0, this, Integer.MIN_VALUE, Integer.MAX_VALUE, a changer);
            if (score > this.MaxScore) {
                this.MaxScore = score;
                moves.clear();
                moves.add(move);
            } else if (score == this.MaxScore) {
                moves.add(move);
            }
        }
        return moves;
    }

    public int alphaBeta (Board board, int depth, CPUPlayer player, int alpha, int beta, boolean maximizingPlayer) {
        this.numExploredNodes++;
        if (depth == 9 || board.isOver()) {
            return board.evaluate(player.getMark());
        }

        if (maximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (Move move : board.getMovesPossibles()) {
                Board newBoard = board.clone();
                newBoard.play(move, player.getMark());
                int eval = alphaBeta(newBoard, depth + 1, player, alpha, beta, false);
                maxEval = Math.max(maxEval, eval);
                alpha = Math.max(alpha, eval);
                if (beta <= alpha) {
                    return maxEval;
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (Move move : board.getMovesPossibles()) {
                Board newBoard = board.clone();
                newBoard.play(move, player.getMark().other());
                int eval = alphaBeta(newBoard, depth + 1, player, alpha, beta, true);
                minEval = Math.min(minEval, eval);
                beta = Math.min(beta, eval);
                if (beta <= alpha) {
                    return minEval;
                }
            }
            return minEval;
            
        }
    }

}
