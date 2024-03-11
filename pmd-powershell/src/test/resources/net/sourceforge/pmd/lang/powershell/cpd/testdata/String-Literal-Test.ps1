"This string contains a subexpression $($subExprVat + "with an inner expandable string $innerVar $(SubExpr $innerSubexprVar)") which has more variables"
@"
This here-string contains double quotes " and a subexpression $($subExprVat + "with an inner expandable string $innerVar $(SubExpr $innerSubexprVar)") which has more variables"
"@
'This string contains a subexpression $($subExprVat + "with an inner expandable string $innerVar $(SubExpr $innerSubexprVar)") which has more variables'
@'
This here-string contains double quotes " and a subexpression $($subExprVat + "with an inner expandable string $innerVar $(SubExpr $innerSubexprVar)") which has more variables"
'@
