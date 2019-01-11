package io.spring.initializr.generator;

import io.spring.initializr.util.Layer;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "layer-config")
public class LayerConfig {

    private List<Layer> layers;

    public LayerConfig() {
        this.layers = new ArrayList<>();
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }
}