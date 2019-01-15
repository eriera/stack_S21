package io.spring.initializr.generator;

import io.spring.initializr.util.DockerImage;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "docker")
public class DockerConfig {

    private List<DockerImage> images;

    public DockerConfig() {
        this.images = new ArrayList<>();
    }

    public List<DockerImage> getImages() {
        return images;
    }

    public void setLayers(List<DockerImage> images) {
        this.images = images;
    }
}