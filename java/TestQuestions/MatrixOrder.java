package TestQuestions;

/**
 * Created by jun on 3/23/2015.
 */
enum Direction {
    EAST, SOUTH, WEST, NORTH;

    public Direction getNextDirection(Direction direction) {
        switch (direction) {
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                return EAST;
        }
    }
}

public class MatrixOrder {
    public int[] walk(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }

        int cols = matrix[0].length;
        int rows = matrix.length;

        // validate input is a matrix
        if (cols == 0) {
            return null;
        }
        for (int i = 1; i < rows; i++) {
            if (cols != matrix[i].length) {
                return null;
            }
        }

        Direction currentDirection = Direction.EAST;
        int up = 0;
        int low = rows - 1;
        int left = 0;
        int right = cols - 1;
        int[] result = new int[cols * rows];
        int currentX = 0, currentY = 0;
        int count = 0;

        // walking clockwise
        while (count < cols * rows) {
            switch (currentDirection) {
                case EAST:
                    while (currentY <= right) {
                        result[count] = matrix[currentX][currentY];
                        count++;
                        currentY++;
                    }
                    currentDirection = currentDirection.getNextDirection(currentDirection);
                    currentX++;
                    currentY--;
                    up++;
                    break;
                case SOUTH:
                    while (currentX <= low) {
                        result[count] = matrix[currentX][currentY];
                        count++;
                        currentX++;
                    }
                    currentDirection = currentDirection.getNextDirection(currentDirection);
                    currentY--;
                    currentX--;
                    right--;
                    break;
                case WEST:
                    while (currentY >= left) {
                        result[count] = matrix[currentX][currentY];
                        count++;
                        currentY--;
                    }
                    currentDirection = currentDirection.getNextDirection(currentDirection);
                    currentX--;
                    currentY++;
                    low--;
                    break;
                case NORTH:
                    while (currentX >= up) {
                        result[count] = matrix[currentX][currentY];
                        count++;
                        currentX--;
                    }
                    currentDirection = currentDirection.getNextDirection(currentDirection);
                    currentY++;
                    currentX++;
                    left++;
                    break;
            }
        }

        return result;
    }
}
