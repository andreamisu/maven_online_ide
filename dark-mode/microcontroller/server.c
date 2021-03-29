#include <sys/socket.h> /* struct sockaddr, socket, bind, listen, accept, AF_INET, SOCK_STREAM */
#include <netinet/in.h> /* struct sockaddr_in, IPPROTO_TCP, INADDR_ANY  */
#include <string.h> /* strlen */
#include <unistd.h> /* write, sleep, close */

int main(int argc, char *argv[]) {
    /* initialize socket (file) handles and constants */
    int listen_fd = 0, conn_fd = 0, server_port = 5000;
    char response_buffer[128] = "HTTP/1.1 200 OK\n"
        "Content-Length: 22\n"
        "Content-Type: text/html\n"
        "\n"
        "I wrote a server in c!";
    struct sockaddr_in server_addr;

    /* Clear structure */
    memset(&server_addr, 0, sizeof(server_addr));
    server_addr.sin_family = AF_INET;
    server_addr.sin_addr.s_addr = htonl(INADDR_ANY); // converts unsigned int to network byte order
    server_addr.sin_port = htons(server_port); // converts unsigned short int to network byte order

    // TODO: implement web server
    // create socket in kernel via 'socket' syscall
    // returns a socket handle
    // AF_INET: internat family of IPv4 adresses
    listen_fd = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
    
    // syscall 'bind' assigns the details specified in the 'server_addr' strucute to the socket
    bind(listen_fd, (struct sockaddr *) &server_addr, sizeof(server_addr));
    
    // syscall 'listen' for max. client connection amount (this is arbitraty for us so we choose 10)
    listen(listen_fd, 10);
    
    while(1) {
        // syscall 'accept' puts server to sleep and will accept incoming client requests which are then assigned to `conn_fd` (new socket handle
        conn_fd = accept(listen_fd, (struct sockaddr *) NULL, NULL);
        
        // writng to the client socket by using the descriptor returned by `accept`
        write(conn_fd, response_buffer, strlen(response_buffer));
        
        close(conn_fd);
        sleep(1);
    }
}

