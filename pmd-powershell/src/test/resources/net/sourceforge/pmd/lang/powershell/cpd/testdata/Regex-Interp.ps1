$RegexExample = "^\sExpandableString with a $var and some .* regex$";
$AnotherExample = "^\sExpandableString with a $var";

$RegexExample = @"
^\sExpandableHereString with a $var and some .* regex$
"@;

$AnotherExample = @"
^\sExpandableHereString with a $var
"@;

$AnotherExample = @"
^\sExpandableHereString with a $var
"@;

$RegexExample = @"
^\sExpandableHereString with a $var and some .* regex$
and another line
"@;

$multSring = "
^\sExpandableHereString with a $var and some .* regex$
and another line
"
