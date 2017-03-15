$(function() {

    var searchResultTemplate = Handlebars.compile($("#search-result-template").html());
    var paramTemplate = Handlebars.compile($("#param-template").html());

    loadPreDefinedSearch();
    addParam();

    $("#custom-search .search-submit").click(function() {
        var q = $("#query").val().trim()
        var params = $(".param input").map(function(index, item) {
            return $(item).val();
        })

        findByQuery(q, params.toArray(), "#custom-search .error", function (data) {
            $("#custom-search .search-result").html(searchResultTemplate({comments: data.comments}));
            $("#custom-search .time").html(data.time)
            $("#custom-search .loaded-count").html(data.count)
        })
    })

    $("#add-param").click(function() {
        addParam();
    })

    $(".params-container").on('click', '.param .remove', function(event){
        $(event.target).parents(".param").remove()
    });

    $("#pre-defined-search .search-submit").click(loadPreDefinedSearch)

    function loadPreDefinedSearch() {
        var selectedOption = $("#pre-defined-search .form-control option:selected")
        var q = selectedOption.val().trim()
        var params = selectedOption.attr('params').split(",")
        findByQuery(q, params, "#pre-defined-search .error", function(data) {
            $("#pre-defined-search .search-result").html(searchResultTemplate({comments: data.comments}));
            $("#pre-defined-search .time").html(data.time);
            $("#pre-defined-search .loaded-count").html(data.comments.length)
            showLoadedMessage()
        })
    }

    function findByQuery(q, params, errorSelector, handler, fail) {
        if(q != "") {
            $.ajax({
                url: 'query?q='+ q + "&p=" + params.join("&p="),
                success: function(data) {
                    $(errorSelector).hide()
                    handler(data)
                },
                error : function(xhr, textStatus, errorThrown) {
                    $(errorSelector).html(errorThrown)
                    $(errorSelector).show()
                }
            });
        }
    }

    function addParam() {
        $(".params-container").append(paramTemplate())
    }

    function showLoadedMessage() {
        $("#loaded-message").show()
        setTimeout(function() {
            $("#loaded-message").hide()
        }, 1000)
    }

})