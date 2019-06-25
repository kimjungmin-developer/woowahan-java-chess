package chess.model;

import chess.model.piece.*;

import java.util.*;

public class ContinueGameCreateStrategy implements CreateStrategy {
    private BoardDTO dto;

    public ContinueGameCreateStrategy(BoardDTO dto) {
        this.dto = dto;
    }

    @Override
    public Map<String, Tile> create() {
        Map<String, Tile> tiles = new HashMap<>();

//        Map<String, Function<String, Piece>> mapper = new HashMap<>() {{
//            put("k", King::new);
//        }};


        List<String> pieces = dto.getPieces();
        Collections.reverse(pieces);
        System.err.println(pieces);

// TODO: 2018-06-25 stream 사용하기
        for (int i = 7; i >= 0; i--) {
            String row = pieces.get(i);
            for (int j = 1; j <= 8; j++) {
                String piece = row.substring(j - 1, j);
                if (piece.equals("K")) {
                    String coordinate = String.valueOf(j) + (i + 1);
                    tiles.put(coordinate, new Tile(coordinate, Optional.of(new King("black"))));
                }
                if (piece.equals("Q")) {
                    String coordinate = String.valueOf(j) + (i + 1);
                    tiles.put(coordinate, new Tile(coordinate, Optional.of(new Queen("black"))));
                }
                if (piece.equals("B")) {
                    String coordinate = String.valueOf(j) + (i + 1);
                    tiles.put(coordinate, new Tile(coordinate, Optional.of(new Bishop("black"))));
                }
                if (piece.equals("R")) {
                    String coordinate = String.valueOf(j) + (i + 1);
                    tiles.put(coordinate, new Tile(coordinate, Optional.of(new Rook("black"))));
                }
                if (piece.equals("N")) {
                    String coordinate = String.valueOf(j) + (i + 1);
                    tiles.put(coordinate, new Tile(coordinate, Optional.of(new Knight("black"))));
                }
                if (piece.equals("P") && (i + 1) == 2) {
                    String coordinate = String.valueOf(j) + (i + 1);
                    tiles.put(coordinate, new Tile(coordinate, Optional.of(new Pawn(false, "black"))));
                }
                if (piece.equals("P") && (i + 1) != 2) {
                    String coordinate = String.valueOf(j) + (i + 1);
                    tiles.put(coordinate, new Tile(coordinate, Optional.of(new Pawn(true, "black"))));
                }
                if (piece.equals("k")) {
                    String coordinate = String.valueOf(j) + (i + 1);
                    tiles.put(coordinate, new Tile(coordinate, Optional.of(new King("white"))));
                }
                if (piece.equals("q")) {
                    String coordinate = String.valueOf(j) + (i + 1);
                    tiles.put(coordinate, new Tile(coordinate, Optional.of(new Queen("white"))));
                }
                if (piece.equals("b")) {
                    String coordinate = String.valueOf(j) + (i + 1);
                    tiles.put(coordinate, new Tile(coordinate, Optional.of(new Bishop("white"))));
                }
                if (piece.equals("r")) {
                    String coordinate = String.valueOf(j) + (i + 1);
                    tiles.put(coordinate, new Tile(coordinate, Optional.of(new Rook("white"))));
                }
                if (piece.equals("n")) {
                    String coordinate = String.valueOf(j) + (i + 1);
                    tiles.put(coordinate, new Tile(coordinate, Optional.of(new Knight("white"))));
                }
                if (piece.equals("p") && (i + 1) == 7) {
                    String coordinate = String.valueOf(j) + (i + 1);
                    tiles.put(coordinate, new Tile(coordinate, Optional.of(new Pawn(false, "white"))));
                }
                if (piece.equals("p") && (i + 1) != 7) {
                    String coordinate = String.valueOf(j) + (i + 1);
                    tiles.put(coordinate, new Tile(coordinate, Optional.of(new Pawn(true, "white"))));
                }
                if (piece.equals("#")) {
                    String coordinate = String.valueOf(j) + (i + 1);
                    tiles.put(coordinate, new Tile(coordinate, Optional.empty()));
                }
            }
        }
        System.err.println(tiles.size());

        return tiles;
    }
}