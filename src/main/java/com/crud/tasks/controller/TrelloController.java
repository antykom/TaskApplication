package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("v1/trello")
@RequiredArgsConstructor
public class TrelloController {

    private final TrelloClient trelloClient;

    @GetMapping("boards")
    public void getTrelloBoards() {
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.stream()
                .filter(e -> !e.getId().isEmpty())
                .filter(e -> !e.getName().isEmpty() && e.getName().contains("Kodilla"))
                .peek(e -> System.out.println(e.getId() + " " + e.getName()))
                .collect(Collectors.toList());
/**
 trelloBoards.forEach(trelloBoardDto -> {
 if (!trelloBoardDto.getId().isEmpty() && !trelloBoardDto.getName().isEmpty() && trelloBoardDto.getName().contains("Kodilla")) {
 System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
 }
 });
 **/
    }
}
