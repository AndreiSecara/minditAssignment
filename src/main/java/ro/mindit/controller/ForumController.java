package ro.mindit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.mindit.model.Forum;
import ro.mindit.model.Post;
import ro.mindit.service.ForumService;
import ro.mindit.service.PostService;

@Controller
public class ForumController {

	@Autowired
	ForumService forumService;
	@Autowired
	PostService postService;

	@RequestMapping(value = "/forums", method = RequestMethod.GET)
	public ModelAndView forums() {
		ModelAndView model = new ModelAndView();
		model.setViewName("forums");
		model.addObject("listForums", forumService.listForums());
		model.addObject("forum", new Forum());
		return model;
	}

	@RequestMapping(value = "/addForum", method = RequestMethod.POST)
	public String addForum(@ModelAttribute("forum") Forum forum) {
		if (!forumService.forumExists(forum.getName())) {
			forumService.addForum(forum);
		}
		return "redirect:/forums";
	}

	@RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
	public ModelAndView selectForum(@PathVariable("id") int id, @ModelAttribute("post") Post post) {
		Forum forum = forumService.getForumById(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("selectedForum");
		model.addObject("forum", forum);
		model.addObject("listPosts", postService.listPosts(id));
		return model;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String removeForum(@PathVariable("id") int id) {
		forumService.deleteForum(id);
		return "redirect:/forums";
	}
	
	@RequestMapping(value="/addPost/{id}", method = RequestMethod.POST)
	public String addPost(@ModelAttribute("post") Post post, @PathVariable("id") int id) {
		Post newPost= new Post(id, post.getPostContent());
		postService.addPost(newPost);
		return "redirect:/select/"+id;
	}
	
}
