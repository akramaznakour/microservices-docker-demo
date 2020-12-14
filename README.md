If you don't have one, [create an Okta Developer account](https://developer.okta.com/signup/). After you've completed the setup process, log in to your account and navigate to **Applications** > **Add Application**. Click **Web** and **Next**. On the next page, enter a name for your app (e.g., "Spring Docker"), then click **Done**. 

Copy your issuer (found under **API** > **Authorization Servers**), client ID, and client secret into `config-data/school-ui.properties`.

Create another Web application and name it something like "Spring Docker Production". Copy the client ID and secret into `config-data/school-ui-production.properties`. 

Run the following command from the root folder to create Docker containers for all your apps.

```shell
    mvnw.cmd clean install
```

Then you can start your microservices architecture using Docker Compose:

```shell
    docker-compose up -d
```
