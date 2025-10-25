import javax.imageio.ImageIO;           // ImageIO is a utility class from javax.imageio that provides static methods for reading and writing image files in formats like PNG and JPEG.
import javax.swing.*;                   // JFrame, JLabel, and ImageIcon are GUI component classes from javax.swing, used to build windowed interfaces with text and image display capabilities.
import java.awt.*;                      // Color, Image, and BorderLayout are classes from java.awt for managing colors, image rendering, and component layout in graphical user interfaces.
import java.io.IOException;             // IOException is a checked exception class from java.io that signals failure during input or output operations.
import java.io.InputStream;             // InputStream is an abstract class from java.io that represents a stream of bytes used for reading data from sources like files.
import java.net.URI;                    // URI is a class from java.net that models Uniform Resource Identifiers. String of characters that identifies something, like a location, name, or resource,
import java.net.http.HttpClient;        // HttpClient is a class from java.net.http that sends HTTP requests and receives responses, supporting both synchronous and asynchronous communication.
import java.net.http.HttpRequest;       // HttpRequest is a class from java.net.http that represents an HTTP request and uses a builder pattern to configure headers, methods, and URIs (Uniform Resource Identifier - Explained in chatgpt for students link).
import java.net.http.HttpResponse;      // HttpResponse is a class from java.net.http that encapsulates the result of an HTTP request, including status code, headers, and body content.

void main() {
    try {
        // avatarStream is a local variable of type InputStream type from java.io, used to hold the image stream returned by getRandomAvatarStream().
        // getRandomAvatarStream() is a method call that returns an InputStream type containing image data. It is defined in the same class and invoked here as an instance method, used to fetch a randomly generated avatar from an external API.
        // showAvatar() is a method call that takes an InputStream type as an argument and displays the image in a GUI window. It is defined in the same class and invoked as an instance method.
        var avatarStream = getRandomAvatarStream();
        showAvatar(avatarStream);

        // IOException is a checked exception from java.io signaling I/O failures, and InterruptedException is from java.lang indicating thread interruption; both are types used in the catch clause to handle potential runtime errors.
        // printStackTrace() is an instance method of the Throwable class (superclass of both exceptions presented), it is used to print the stack trace of the caught exception to standard error for debugging purposes.
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
}

// InputStream is an abstract class of  superclass which all classes representing an input stream of bytes. (I had some doubts here. I asked chatgpt for students).
    // answer 1: An abstract class is a class that cannot be directly instantiated (you can’t do new InputStream()).
    // answer 2: It only provides general behaviors and a template for other classes to extend and implement.
    // answer 3: InputStream is an abstract parent class in Java that defines how to read a sequence (stream) of bytes from different sources. Other classes extend it to handle specific input sources.
// IOException is a checked exception from java.io signaling I/O failures, and InterruptedException is from java.lang indicating thread interruption; both are types used in the catch clause to handle potential runtime errors.

InputStream getRandomAvatarStream() throws IOException, InterruptedException {
    // Pick a random style
    // random() is a class method from java.lang.Math that returns a pseudorandom double between 0.0 and 1.0, used here to randomly index the style array and generate a seed.
    // styles is a type array of String from java.lang, used to store predefined avatar style names for random selection.
    // length represents the number of elements in the styles array. It is an instance variable of the array object from java.lang.
    // style is a type of String, it receives a randomly selected value from the styles array to define the avatar's visual style.
    String[] styles = { "adventurer", "adventurer-neutral", "avataaars", "big-ears", "big-ears-neutral", "big-smile", "bottts", "croodles", "croodles-neutral", "fun-emoji", "icons", "identicon", "initials", "lorelei", "micah", "miniavs", "open-peeps", "personas", "pixel-art", "pixel-art-neutral" };
    var style = styles[(int)(Math.random() * styles.length)];

    // Generate a random seed
    // seed is an int type representing a randomly generated number between 0 and 9999, used to uniquely identify the avatar.
    // (int)() is the cast to int converts the double result of Math.random() into an integer, which is the primary or primitive type used to index the array and generate the sequence.
    var seed = (int)(Math.random() * 10000);

    // Create an HTTP request for a random avatar
    // create() is a class method of URI from java.net, which analyses the formatted URL string and returns a URI object type representing the avatar API code & endpoint.
    // HttpRequest.Builder is a nested class inside java.net.http.HttpRequest. (I had some doubts here. I asked chatgpt for students).
        // answer 1: HttpRequest.Builder = a configurator for HttpRequest.
    // newBuilder() is a class method of HttpRequest from java.net.http, which returns a HttpRequest.Builder initialized with the given URI.
    // build() is an instance method of HttpRequest.Builder from java.net.http, which finalizes and returns a constructed HttpRequest object type.
    var uri = URI.create("https://api.dicebear.com/9.x/%s/png?seed=%d".formatted(style, seed));
    var request = HttpRequest.newBuilder(uri).build();

    // Send the request
    // newHttpClient() is a class method of HttpClient from java.net.http, which returns a default-configured HttpClient instance type for sending requests. The default settings include: the "GET" request method, a preference of HTTP/2.
    // send() is an instance method of HttpClient from java.net.http, which sends the HTTP request synchronously and returns an HttpResponse<InputStream> containing the server’s reply.
        // Sends the given request using this client, blocking if necessary to get the response. The returned HttpResponse<T> contains the response status, headers, and body (as handled by given response body handler). Copied by documentation.
    // ofInputStream() is a class method of HttpResponse.BodyHandlers from java.net.http, which specifies that the response body should be returned as an InputStream. (InputStram was imported from the beginning of this document).
    // body() is an instance method of HttpResponse<InputStream> from java.net.http, which extracts the response content as an InputStream as type for image decoding. (InputStram was imported from the beginning of this document).
    // return response.body() returns the InputStream as type containing the avatar image data to the caller, satisfying the method’s declared return type.
    try (var client = HttpClient.newHttpClient()) {
        var response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
        return response.body();
    }
}

// InputStream is an abstract class of  superclass which all classes representing an input stream of bytes. (I had some doubts here. I asked chatgpt for students).
    // answer 1: An abstract class is a class that cannot be directly instantiated (you can’t do new InputStream()).
    // answer 2: It only provides general behaviors and a template for other classes to extend and implement.
    // answer 3: InputStream is an abstract parent class in Java that defines how to read a sequence (stream) of bytes from different sources. Other classes extend it to handle specific input sources.
// imageStream is a parameter of type InputStream from java.io, a type representing a stream of bytes used to read the avatar image data.
void showAvatar(InputStream imageStream) {

    // "new JFrame("PNG Viewer")": JFrame is a class from javax.swing, and this is a constructor method that creates a new top-level window titled "PNG Viewer" for displaying the avatar image.
    // setDefaultCloseOperation() is an instance method of JFrame from javax.swing, which sets the window’s close behavior, and the EXIT_ON_CLOSE is a class variable that instructs the application to terminate when the window is closed.
    // setResizable() is an instance method of JFrame from javax.swing, used to disable the ability to resize the window; the argument false is a primitive boolean.
    // setSize() is an instance method of JFrame from javax.swing, which sets the window dimensions to 200x200 pixels; both arguments are primitive int values.
    // getContentPane() is an instance method of JFrame from javax.swing, which returns a Container object type representing the window’s content area.
    // setBackground() is an instance method of Container from java.awt, used to set the background color. The Color.BLACK is a class variable from java.awt.Color representing the black color constant.
    JFrame frame = new JFrame("PNG Viewer");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setSize(200, 200);
    frame.getContentPane().setBackground(Color.BLACK);

    try {
        // Load the PNG image
        // read() is a class method of ImageIO from javax.imageio, which reads image data from the InputStream and returns an Image object type from java.awt.
        Image image = ImageIO.read(imageStream);

        // Create a JLabel to display the image
        // JLabel is a class from javax.swing, and this is a constructor method that creates a label to hold and display a given image icon.
            // The label is centered vertically and horizontally in its display area.
        // add() is an instance method of JFrame from javax.swing, which adds the JLabel to the frame’s layout.
        // BorderLayout.CENTER is a class variable from java.awt.BorderLayout indicating central placement.
            // A border layout lays out a container, arranging and resizing its components to fit in five regions: north, south, east, west, and center.
            // Each region may contain no more than one component, and is identified by a corresponding constant: NORTH, SOUTH, EAST, WEST, and CENTER.
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        frame.add(imageLabel, BorderLayout.CENTER);

    } catch (IOException e) {
        // printStackTrace() is an instance method of Throwable from java.lang, used to print the exception’s stack trace to standard error for debugging.
            // The first line of output contains the result of the toString() method for this object.
        e.printStackTrace();
    }

    // setVisible() is an instance method of JFrame from javax.swing, which shows or hides this Window depending on the value of parameter b.
        // If the method shows the window then the window is also made focused.
        // The argument true is a primitive boolean. Native windowing system allows the Window to get focused.
    frame.setVisible(true);
}
// DONE Lab#2
