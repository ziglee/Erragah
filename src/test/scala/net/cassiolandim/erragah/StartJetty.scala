package net.cassiolandim.erragah

import org.mortbay.jetty.Connector
import org.mortbay.jetty.Server
import org.mortbay.jetty.bio.SocketConnector
import org.mortbay.jetty.webapp.WebAppContext

object StartJetty extends Application {
	val server : Server = new Server()
	val connector : SocketConnector = new SocketConnector()
	connector.setPort(8080)
	server.setConnectors(Array[Connector] ( connector ))

	val bb : WebAppContext = new WebAppContext()
	bb.setServer(server)
	bb.setContextPath("/erragah")
	bb.setWar("src/main/webapp")
	
	server.addHandler(bb)

	try {
		println(">>> STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP")
		server.start()
		while (System.in.available() == 0) {
			Thread.sleep(5000)
		}
		server.stop()
		server.join()
	} catch {
		case ex : Exception => {
			ex.printStackTrace()
			System.exit(100)
		}
	}
}
