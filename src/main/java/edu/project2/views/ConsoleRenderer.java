package edu.project2.views;

import edu.project2.models.Coordinate;
import edu.project2.models.Maze;
import java.util.List;

public class ConsoleRenderer implements Renderer {
    @Override
    public String render(Maze maze) {
        StringBuilder renderedMaze = new StringBuilder();

        for (int i = 0; i < maze.height(); i++) {
            for (int j = 0; j < maze.width(); j++) {
                renderedMaze.append(getCellViewByCell(maze.grid()[i][j]).getView());
            }
            renderedMaze.append("\n");
        }
        return String.valueOf(renderedMaze);
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        maze.validatePath(path);

        var gridView = new CellView[maze.height()][maze.width()];
        for (int i = 0; i < maze.height(); i++) {
            for (int j = 0; j < maze.width(); j++) {
                gridView[i][j] = getCellViewByCell(maze.grid()[i][j]);
            }
        }
        path.forEach(coordinate -> gridView[coordinate.row()][coordinate.col()] = CellView.PATH);

        gridView[path.getFirst().row()][path.getFirst().col()] = CellView.START;
        gridView[path.getLast().row()][path.getLast().col()] = CellView.FINISH;

        StringBuilder renderedMaze = new StringBuilder();
        for (int i = 0; i < maze.height(); i++) {
            for (int j = 0; j < maze.width(); j++) {
                renderedMaze.append(gridView[i][j].getView());
            }
            renderedMaze.append(System.lineSeparator());
        }
        return String.valueOf(renderedMaze);
    }

    private enum CellView {
        WALL('▆'), PASSAGE(' '), START('☺'), PATH('·'), FINISH('⚑');
        private final char view;

        CellView(char view) {
            this.view = view;
        }

        public String getView() {
            return String.valueOf(view);
        }
    }

    private CellView getCellViewByCell(Maze.Cell cell) {
        return switch (cell) {
            case WALL -> CellView.WALL;
            case PASSAGE -> CellView.PASSAGE;
        };
    }
}
