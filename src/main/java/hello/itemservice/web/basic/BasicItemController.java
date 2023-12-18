package hello.itemservice.web.basic;


import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;


    @GetMapping
    public String items(Model model){

        List<Item> items = itemRepository.findAll();
        model.addAttribute("items",items);

        return "basic/items";
    }

    @GetMapping("{itemId}")
    public String item(@PathVariable Long itemId, Model model)  {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "basic/item";
    }


    @GetMapping("/add")
    public String addForm(){
        return "basic/addForm";
    }

//    @PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                       @RequestParam Integer price,
                       @RequestParam Integer quantity,
                       Model model){
        Item item = new Item(itemName,price,quantity);
        itemRepository.save(item);
        model.addAttribute("item",item);
        return "basic/item";
    }



//    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item,Model model){
        itemRepository.save(item);
//        model.addAttribute("item",item); // 자동추가 ,삭제 가능
        return "basic/item";
    }


//    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item){ //( 생략 가능 )
        itemRepository.save(item);
        return "basic/item";
    }


//    @PostMapping("/add")
    public String addItemV4(Item item){ //(@ModelAttribute를 생략가능)
        itemRepository.save(item);
        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV5(Item item){ //(@ModelAttribute를 생략가능)
        itemRepository.save(item);
        return "redirect:basic/items/"+item.getId();
    }

    @PostMapping("/add")
    public String addItemV6(Item item, RedirectAttributes redirectAttributes){ // RedirectAttribute객체 사용.
        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId",savedItem.getId());
        redirectAttributes.addAttribute("status",true); // 쿼리 파라미터 형식으로 insert된다.
        return "redirect:basic/items/{itemId}";
    }


    @GetMapping("/{ItemId}/edit")
    public String editForm(@PathVariable Long itemId,Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "basic/editForm";

    }

    @PostMapping("/{ItemId}/edit")
    public String edit(@PathVariable Long itemId,
                       @ModelAttribute Item item){
        itemRepository.update(itemId,item);

        return "redirect:/basic/items/{itemId}";

    }



    /**
     * 테스트용
     */
    @PostConstruct
    public void init(){
        itemRepository.save(new Item("itemA",10000,10));
        itemRepository.save(new Item("itemB",120000,20));

    }
}
