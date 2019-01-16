

public interface ShapeInterface {
    String toString();
    String getKind();
    String getDetailedString();
    int getID();
}
// ShapeInterface implements the assigned functions. Although
// I didn't see that it was required until about halfway through the exam,
// luckily I had already implemented most of the interface's functionality
// using an abstract class: Shape. Implementing the interface actually worked really
// smoothly with the abstract base class and ended up saving a lot of code.