package Exceptions;

public class ServiceLayerWorker {
    public void doSomethingWrapExceptions(String filename) {
        try ( FileResource resource = new FileResource(filename) ) {
            resource.doSomething();
        } catch ( ResourceNotFoundException e ) {
            throw new ServiceLayerException("resource not found", e);
        } catch ( Exception e) {
            throw new ServiceLayerException(e.getMessage(), e);
        }
    }

    public boolean tryDoSomethingSuppressException(String filename) {
        try ( FileResource resource = new FileResource(filename) ) {
            resource.doSomething();
            return true;
        } catch ( Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void doSomethingPassingExceptions(String filename) throws ResourceNotFoundException {
        try ( FileResource resource = new FileResource(filename) ) {
            resource.doSomething();
        }
    }

}
