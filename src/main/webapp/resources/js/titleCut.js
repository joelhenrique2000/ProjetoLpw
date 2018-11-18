                var title = document.querySelectorAll('.titulo');
                var tamanho = title.length;
for(var i=0; i < tamanho ; i++) {
        var t = title[i];
        if((t.innerHTML.length) > 59) {
            t.innerHTML = t.innerHTML.substring(0,60) + "...";
        }
}