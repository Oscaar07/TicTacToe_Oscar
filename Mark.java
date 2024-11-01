
enum Mark {
    X,
    O,
    EMPTY;

    public Mark other() {
        if (this == Mark.X) {
            return Mark.O;
        } else if (this == Mark.O) {
            return Mark.X;
        } else {
            return Mark.EMPTY;
        }
    }
}
    

