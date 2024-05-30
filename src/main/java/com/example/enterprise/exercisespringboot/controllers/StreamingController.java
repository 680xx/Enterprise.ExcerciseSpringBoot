package com.example.enterprise.exercisespringboot.controllers;

import com.example.enterprise.exercisespringboot.StreamingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StreamingController {

    List<StreamingService> streamingServices = new ArrayList<>(List.of(
            new StreamingService(1, "HBO", "4K", 129),
            new StreamingService(2, "Netflix", "HD", 99),
            new StreamingService(3, "Viaplay", "SD", 79)));

    @RequestMapping(value="/streamingservices", method = RequestMethod.GET)
    @ResponseBody
    public List<StreamingService> getStreamingServices() {
        return streamingServices;
    }

    @RequestMapping(value = "/streamingservice/{id}", method = RequestMethod.GET)
    @ResponseBody
    public StreamingService getStreamingServiceById(@PathVariable("id") int id) {
        for (StreamingService streamingService: streamingServices) {
            if (streamingService.getId() == id) {
                return streamingService;
            }

        }
        return null;
    }

    public StreamingService returnService (int sid) {
        return streamingServices.get(sid);
    }

}
