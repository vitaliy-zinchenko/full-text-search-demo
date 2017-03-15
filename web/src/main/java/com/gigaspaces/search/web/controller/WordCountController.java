package com.gigaspaces.search.web.controller;

import com.gigaspaces.search.model.Comment;
import com.gigaspaces.search.web.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class WordCountController {

    @Autowired
    private CommentService service;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public CommentsResponse query(@RequestParam("q") String query,
                                  @RequestParam("p") List<String> parameters) {
        Long start = System.currentTimeMillis();
        Comment[] comments = service.getComments(query, parameters);
        Long finish = System.currentTimeMillis();
        Long time = finish - start;
        Comment[] commentsHead = Arrays.copyOf(comments, comments.length > 100 ? 100 : comments.length);
        return new CommentsResponse(commentsHead, time, comments.length);
    }

    static class CommentsResponse {
        private Comment[] comments;
        private Long time;
        private Integer count;

        public CommentsResponse(Comment[] comments, Long time, Integer count) {
            this.comments = comments;
            this.time = time;
            this.count = count;
        }

        public Comment[] getComments() {
            return comments;
        }

        public Long getTime() {
            return time;
        }

        public Integer getCount() {
            return count;
        }
    }

}


