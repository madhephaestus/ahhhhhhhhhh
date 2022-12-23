// Create a LengthParameter object to represent the pipe diameter
// Create a LengthParameter object to represent the pipe diameter
List<Double> range = new ArrayList<Double>();
range.add(2.0);
range.add(60.0);
LengthParameter pipeDiameter = new LengthParameter(35, "mm", range);
// Create a cylinder to represent the pipe
double pipeRadius = pipeDiameter.getValue()/2;
double pipeLength = 800;
CSG pipe = new Cylinder(pipeRadius, pipeLength).toCSG();

// Create a box to represent the board
double boardWidth = 2 * 2 * pipeRadius;
double boardHeight = 2 * 2 * pipeRadius;
double boardThickness = 2;
CSG board = new Cube(boardWidth, boardHeight, boardThickness).toCSG();

// Position the pipe and board
double pipeX = 0;
double pipeY = 0;
double pipeZ = 0;
double boardX = 0;
double boardY = 0;
double boardZ = 0;
pipe = pipe.move(pipeX, pipeY, pipeZ);
board = board.move(boardX, boardY, boardZ);

// Connect the pipe to the board
double connectionRadius = 0.2;
double connectionX = pipeX;
double connectionY = pipeY;
double connectionZ = pipeZ + pipeLength/2;
CSG connection = new Sphere(connectionRadius).toCSG().move(connectionX, connectionY, connectionZ);
CSG model = board.union(pipe).union(connection);

// Return the model
return model;
