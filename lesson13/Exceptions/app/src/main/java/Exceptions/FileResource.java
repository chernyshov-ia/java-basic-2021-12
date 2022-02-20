package Exceptions;

public class FileResource implements AutoCloseable {
    private final String filename;

    public FileResource(String filename) throws ResourceNotFoundException {
        super();

        if (filename.startsWith("a")) {
            throw new ResourceNotFoundException("file not found");
        }

        this.filename = filename;
    }

    public void doSomething() {
        if (filename.startsWith("b")) {
            throw new ResourceUnexpectedException("something unexpected");
        }
        System.out.println("Do something with file: " + filename);
    }

    @Override
    public void close() {
        System.out.println("FileResource::close() - resource closed");
    }
}
